# Health Data Exploration & Predictive Modeling

This repository contains a data processing and exploration project that analyzes physical health metrics (such as height and weight) using Python[cite: 2]. The project also demonstrates foundational predictive modeling using basic Linear Regression[cite: 2].

## Overview

The primary objective of this project is to explore a dataset containing participants' physical characteristics to understand patterns in weight fluctuation over time[cite: 2]. The analysis investigates how weight changes relate to current weight, past weight, and age[cite: 2]. Additionally, the project includes a standalone machine learning task to predict housing prices based on square footage[cite: 2].

## Dataset

The main dataset (`ITEC610_assessment3_data.csv`) is derived from a survey measuring physical characteristics[cite: 2]. It contains 414,508 rows and 7 columns, including[cite: 2]:
*   `weight2`: Current weight[cite: 2].
*   `wtyrago`: Weight one year ago[cite: 2].
*   `htm3`: Height of the participant[cite: 2].
*   `age` and `sex` demographics[cite: 2].

## Key Features & Analysis

This project is divided into three core tasks:

1. **Summary Statistics Analysis**[cite: 2]
   * Calculated descriptive statistics (mean, median, standard deviation, min, max, 25th/75th percentiles) for current weight, historical weight, and height[cite: 2].
   * Visualized these summary statistics using customized Matplotlib charts with distinct markers for different statistical values[cite: 2].

2. **Correlation Analysis & Feature Engineering**[cite: 2]
   * Engineered a new feature, `weight_change`, by calculating the difference between current weight and weight a year ago[cite: 2].
   * Generated a correlation dictionary to quantify relationships between weight change and other variables[cite: 2].
   * Created multiple scatter plots to visualize the relationship between weight change vs. current weight, past weight, and age[cite: 2].

3. **Predictive Modeling (Linear Regression)**[cite: 2]
   * Implemented a Linear Regression model using `scikit-learn`[cite: 2].
   * Trained the model on a sample dataset of house sizes (sqft) and corresponding prices[cite: 2].
   * Successfully predicted the price of a 2,500 sqft house using the trained model[cite: 2].

## Technologies Used

*   **Python 3**
*   **Pandas:** For data ingestion, manipulation, and statistical calculations[cite: 2].
*   **Matplotlib:** For generating scatter plots and custom statistical charts[cite: 2].
*   **Scikit-Learn (`sklearn`):** For instantiating, fitting, and predicting with the `LinearRegression` model[cite: 2].
*   **Jupyter Notebook:** For interactive code execution and presentation[cite: 2].

## Key Findings

*   **Weight Trends:** The analysis reveals a strong correlation between a person's weight a year ago and their weight change over time[cite: 2]. 
*   **Current Weight Correlation:** There is a positive correlation between current weight and weight change, indicating individuals with higher current weights tended to have gained more weight recently[cite: 2].
*   **Age Factor:** The variation in weight does not change drastically with age, suggesting that lifestyle or health behaviors may be more significant drivers of weight fluctuation[cite: 2].
