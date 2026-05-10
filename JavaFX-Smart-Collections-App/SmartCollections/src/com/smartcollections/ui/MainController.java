package com.smartcollections.ui;

import com.smartcollections.model.Item;
import com.smartcollections.service.ImportService;
import com.smartcollections.service.IndexService;

import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.DirectoryChooser;
import javafx.util.Duration;

import java.io.File;
import java.util.*;

/**
 * MainController - handles UI logic, event binding, and media preview.
 */
public class MainController {

    // Top toolbar controls
    @FXML private TextField txtSearch;
    @FXML private Button btnImport;
    @FXML private Button btnUndo;
    @FXML private Label lblStatus;

    // Left list of items
    @FXML private ListView<Item> listView;

    // Right detail fields
    @FXML private TextField txtTitle;
    @FXML private ComboBox<String> comboCategory;
    @FXML private TextField txtTags;
    @FXML private Slider sliderRating;
    @FXML private TextField txtPath;
    @FXML private TextArea txtPreview;
    @FXML private MediaView mediaView;

    @FXML private Button btnSave;
    @FXML private Button btnDelete;
    @FXML private Button btnPlay;
    @FXML private Button btnPause;


    // Internal data
    private MediaPlayer mediaPlayer;
    private final ObservableList<Item> itemList = FXCollections.observableArrayList();
    private final IndexService indexService = new IndexService();
    private final Stack<List<Item>> undoStack = new Stack<>();

    /**
     * Called after FXML elements are injected.
     * Sets up category options, search listener, and item selection.
     */
    public void initialize() {
        comboCategory.setItems(FXCollections.observableArrayList("NOTE", "PDF", "AUDIO", "VIDEO", "SNIPPET"));
        listView.setItems(itemList);
        lblStatus.setText("Ready to import.");

        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) loadItemDetails(newVal);
        });

        txtSearch.setOnAction(e -> {
            String keyword = txtSearch.getText().trim();
            if (!keyword.isEmpty()) {
                List<Item> results = indexService.search(keyword);
                itemList.setAll(results);
                lblStatus.setText("Found " + results.size() + " items for '" + keyword + "'");
            }
        });
    }

    /**
     * Loads selected item into detail pane and previews content or media.
     */
    private void loadItemDetails(Item item) {
        txtTitle.setText(item.getTitle());
        comboCategory.setValue(item.getCategory());
        txtTags.setText(item.getTags());
        sliderRating.setValue(item.getRating());
        txtPath.setText(item.getPathOrUrl());
        txtPreview.clear();

        // Stop previous media
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaView.setMediaPlayer(null);
        }

        File file = new File(item.getPathOrUrl());
        if (!file.exists()) {
            txtPreview.setText("File not found.");
            return;
        }

        String path = file.toURI().toString();
        if (path.endsWith(".mp3") || path.endsWith(".wav") || path.endsWith(".mp4") || path.endsWith(".avi")) {
            try {
                Media media = new Media(path);
                mediaPlayer = new MediaPlayer(media);
                mediaView.setMediaPlayer(mediaPlayer);
                mediaPlayer.play();
                txtPreview.setText("Playing media...");
            } catch (Exception e) {
                txtPreview.setText("Error playing media.");
            }
        } else {
            try (Scanner scanner = new Scanner(file)) {
                StringBuilder content = new StringBuilder();
                while (scanner.hasNextLine()) {
                    content.append(scanner.nextLine()).append("\n");
                }
                txtPreview.setText(content.toString());
            } catch (Exception e) {
                txtPreview.setText("Error loading preview.");
            }
        }
    }

    /**
     * Opens folder chooser, imports items recursively, and updates UI.
     */
    @FXML private void handleImportFolder() {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Select Folder to Import");
        File folder = chooser.showDialog(null);

        if (folder != null && folder.isDirectory()) {
            pushUndoState(); // Save current state for undo
            List<Item> importedItems = ImportService.importFolder(folder, List.of());
            indexService.indexMetadata(importedItems);
            indexService.buildMainIndex(importedItems);

            itemList.setAll(importedItems);
            listView.setItems(itemList);
            listView.refresh();
            lblStatus.setText("Imported " + importedItems.size() + " items.");

            // Fade-in animation
            FadeTransition ft = new FadeTransition(Duration.millis(500), listView);
            ft.setFromValue(0.0);
            ft.setToValue(1.0);
            ft.play();
        }
    }

    /**
     * Saves changes to selected item.
     */
    @FXML private void onSaveClicked() {
        Item selected = listView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            pushUndoState(); // Save state before change
            selected.setTitle(txtTitle.getText());
            selected.setCategory(comboCategory.getValue());
            selected.setTags(txtTags.getText());
            selected.setRating((int) sliderRating.getValue());
            selected.setPathOrUrl(txtPath.getText());

            listView.refresh();
            lblStatus.setText("Item saved.");
        } else {
            lblStatus.setText("No item selected.");
        }
    }

    /**
     * Deletes selected item and clears detail pane.
     */
    @FXML private void onDeleteClicked() {
        Item selected = listView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            pushUndoState(); // Save state before deletion
            itemList.remove(selected);
            listView.getSelectionModel().clearSelection();
            clearDetails();
            lblStatus.setText("Item deleted.");
        } else {
            lblStatus.setText("No item selected.");
        }
    }
    
    @FXML private void onPlayClicked() {
        if (mediaPlayer != null) {
            mediaPlayer.play();
            lblStatus.setText("Playing media...");
        }
    }

    @FXML private void onPauseClicked() {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            lblStatus.setText("Media paused.");
        }
    }


    /**
     * Restores previous item list from undo stack.
     */
    @FXML private void onUndoClicked() {
        if (!undoStack.isEmpty()) {
            itemList.setAll(undoStack.pop());
            listView.setItems(itemList);
            listView.refresh();
            lblStatus.setText("Undo successful.");
        } else {
            lblStatus.setText("Nothing to undo.");
        }
    }

    /**
     * Pushes current item list to undo stack.
     */
    private void pushUndoState() {
        undoStack.push(new ArrayList<>(itemList));
    }

    /**
     * Clears all detail fields.
     */
    private void clearDetails() {
        txtTitle.clear();
        comboCategory.setValue(null);
        txtTags.clear();
        sliderRating.setValue(0);
        txtPath.clear();
        txtPreview.clear();
        mediaView.setMediaPlayer(null);
    }
}
