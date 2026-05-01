# Health Data Exploration & Predictive Modeling

This repository contains a data processing and exploration project that analyzes physical health metrics (such as height and weight) using Python. The project also demonstrates foundational predictive modeling using basic Linear Regression.

## Overview

The primary objective of this project is to explore a dataset containing participants' physical characteristics to understand patterns in weight fluctuation over time. The analysis investigates how weight changes relate to current weight, past weight, and age. Additionally, the project includes a standalone machine learning task to predict housing prices based on square footage.

## Dataset

The main dataset (`ITEC610_assessment3_data.csv`) is derived from a survey measuring physical characteristics. It contains 414,508 rows and 7 columns, including:
*   `weight2`: Current weight.
*   `wtyrago`: Weight one year ago.
*   `htm3`: Height of the participant.
*   `age` and `sex` demographics.

## Key Features & Analysis

This project is divided into three core tasks:

1. **Summary Statistics Analysis**
   * Calculated descriptive statistics (mean, median, standard deviation, min, max, 25th/75th percentiles) for current weight, historical weight, and height.
   * Visualized these summary statistics using customized Matplotlib charts with distinct markers for different statistical values.

2. **Correlation Analysis & Feature Engineering**
   * Engineered a new feature, `weight_change`, by calculating the difference between current weight and weight a year ago.
   * Generated a correlation dictionary to quantify relationships between weight change and other variables.
   * Created multiple scatter plots to visualize the relationship between weight change vs. current weight, past weight, and age.

3. **Predictive Modeling (Linear Regression)**
   * Implemented a Linear Regression model using `scikit-learn`.
   * Trained the model on a sample dataset of house sizes (sqft) and corresponding prices.
   * Successfully predicted the price of a 2,500 sqft house using the trained model.

## Technologies Used

*   **Python 3**
*   **Pandas:** For data ingestion, manipulation, and statistical calculations.
*   **Matplotlib:** For generating scatter plots and custom statistical charts.
*   **Scikit-Learn (`sklearn`):** For instantiating, fitting, and predicting with the `LinearRegression` model.
*   **Jupyter Notebook:** For interactive code execution and presentation.

## Key Findings

*   **Weight Trends:** The analysis reveals a strong correlation between a person's weight a year ago and their weight change over time. 
*   **Current Weight Correlation:** There is a positive correlation between current weight and weight change, indicating individuals with higher current weights tended to have gained more weight recently.
*   **Age Factor:** The variation in weight does not change drastically with age, suggesting that lifestyle or health behaviors may be more significant drivers of weight fluctuation.
