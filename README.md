# COVID-19 Daily Deaths Analysis & Visualization

This repository contains a Jupyter Notebook demonstrating essential data preparation and exploratory data analysis (EDA) techniques using a global COVID-19 deaths dataset[cite: 1]. The project showcases how to handle messy real-world data, transform it for analysis, and create informative visualizations using Python's Pandas and Matplotlib libraries[cite: 1].

## Overview

The primary goal of this project is to clean a time-series dataset of COVID-19 deaths and visualize the global trend of daily cumulative deaths alongside the daily increase (new deaths) over a specific period.

## Skills Demonstrated

This project highlights proficiency in the following data science tasks:

*   **Data Loading & Inspection:** Loading data from CSV files and examining its structure[cite: 1].
*   **Data Cleaning:**
    *   Identifying and handling missing values (NaNs)[cite: 1].
    *   Detecting and removing duplicate records[cite: 1].
*   **Data Transformation (Wrangling):**
    *   Reshaping data from wide to long format (melting/unpivoting)[cite: 1].
    *   Standardizing date formats (converting strings to datetime objects)[cite: 1].
*   **Data Aggregation & Grouping:** Grouping data by geographical regions and dates to calculate global metrics[cite: 1].
*   **Feature Engineering:** Calculating daily increments (new cases) from cumulative data using the `.diff()` method[cite: 1].
*   **Data Visualization:** Creating professional line plots with Matplotlib to show trends over time, including titles, labels, legends, and gridlines[cite: 1].
*   **File I/O:** Saving cleaned datasets back to CSV files for further use[cite: 1].

## Technologies Used

*   **Python 3**
*   **Pandas:** For robust data manipulation, cleaning, and analysis[cite: 1].
*   **Matplotlib:** For creating static, interactive, and animated visualizations[cite: 1].
*   **Jupyter Notebook / Google Colab:** For an interactive coding environment[cite: 1].

## Project Structure

*   `ITEC610_Assessment2_S00393664.ipynb`: The main Jupyter Notebook containing all the Python code, analysis, and visualizations[cite: 1].
*   `cleaned_covid19_deaths.csv`: The output dataset after all cleaning and transformation steps have been applied[cite: 1].
*   *(Note: The raw data is loaded directly from a URL within the notebook)*[cite: 1].

## Key Results

The analysis culminates in a line chart visualizing the worldwide trend of COVID-19[cite: 1]. The plot effectively displays two key metrics:
1.  **Daily Deaths (Cumulative):** The total number of deaths recorded up to a specific date (represented by the blue line)[cite: 1].
2.  **Daily Increment in Deaths:** The number of new deaths reported on a specific date (represented by the red line)[cite: 1].

This visualization provides a clear picture of the pandemic's trajectory over the analyzed timeframe[cite: 1].
