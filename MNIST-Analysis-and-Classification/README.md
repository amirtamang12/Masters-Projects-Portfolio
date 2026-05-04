# MNIST Dimensionality Reduction & Classification

This repository contains a Jupyter Notebook (`mnist-pca-tsne-analysis.ipynb`) that explores the MNIST dataset using dimensionality reduction techniques and prepares the data for classification. The project demonstrates fundamental machine learning workflows using Scikit-Learn.

## Overview

The goal of this project is to analyze the MNIST handwritten digit dataset. It begins with data acquisition and initial exploratory data analysis (EDA). The core of the analysis focuses on applying Principal Component Analysis (PCA) and t-Distributed Stochastic Neighbor Embedding (t-SNE) to visualize the high-dimensional image data in a two-dimensional space.

## Key Features

1.  **Data Acquisition & Inspection:**
    *   Loads the MNIST dataset (70,000 images, 28x28 pixels) using `fetch_openml'.
    *   Examines dataset dimensions, categories, and pixel value ranges.
    *   Visualizes a histogram of pixel values for a single sample.

2.  **Exploratory Data Analysis (EDA):**
    *   Plots random samples from each digit category (0-9) to visually inspect the data.
    *   Includes a section to check for "bad data" samples (e.g., faint, distorted, or mislabeled digits).

3.  **Dimensionality Reduction & Visualization:**
    *   Splits the data into training, validation, and test sets.
    *   Applies **PCA (Principal Component Analysis)** to reduce a subset of the data to 2 components and visualizes the result.
    *   Applies **t-SNE (t-Distributed Stochastic Neighbor Embedding)** to a subset of the data for non-linear dimensionality reduction and visualizes the resulting clusters.

## Technologies Used

*   **Python 3**
*   **NumPy:** Numerical operations and array manipulation.
*   **Matplotlib:** Data visualization and plotting.
*   **Scikit-Learn (`sklearn`):**
    *   `fetch_openml`: Dataset loading.
    *   `train_test_split`: Data partitioning.
    *   `PCA`: Linear dimensionality reduction.
    *   `TSNE`: Non-linear dimensionality reduction.
    *   `RandomForestClassifier` & `accuracy_score`: (Imported for potential classification tasks).

## Setup and Usage

1.  Ensure you have Python 3 installed.
2.  Install the required libraries:
    ```bash
    pip install numpy matplotlib scikit-learn
    ```
3.  Run the Jupyter Notebook to view the analysis and visualizations. Note that the t-SNE computation may take some time depending on your hardware.
