# Comprehensive Machine Learning Analysis: Classification & Regression

![Python](https://img.shields.io/badge/Python-3.8%2B-blue)
![Scikit-Learn](https://img.shields.io/badge/Scikit--Learn-Supported-orange)
![TensorFlow](https://img.shields.io/badge/TensorFlow-Neural%20Networks-FF6F00)

An in-depth exploratory and predictive analysis project that applies various machine learning algorithms to both classification and regression tasks. 

## 📖 Overview

This project showcases a complete machine learning pipeline. It covers everything from data preprocessing and dimensionality reduction to model training, evaluation, and statistical comparisons. Specifically, it tackles image classification using the MNIST dataset and predictive regression on the California Housing dataset. 

## ✨ Features

*   **Dimensionality Reduction:** Uses Principal Component Analysis (PCA) and `StandardScaler` to shrink the feature space while keeping 95% of the original data's variance.
*   **K-Nearest Neighbors (kNN):** Implements kNN classification, testing out multiple `k` values (from 1 to 20) to visualize how accuracy changes.
*   **Support Vector Machines (SVM):** Compares the classification performance of Linear and Non-linear (RBF) kernels using detailed reports.
*   **Deep Learning Classification:** Builds a Deep Neural Network (DNN) with TensorFlow and Keras. The architecture includes dense hidden layers, ReLU activation, and Dropout for regularization to accurately predict digit classes.
*   **Statistical Significance Testing:** Uses paired t-tests (`scipy.stats.ttest_rel`) to scientifically validate whether the performance differences between models (like kNN k=5 vs k=10, or SVM vs DNN) are actually meaningful.
*   **Advanced Regression:** Predicts housing prices by comparing standard Linear Regression, Polynomial Regression (Degree 2), Ridge (L2), and Lasso (L1) regularization.
*   **Performance Metrics:** Evaluates the regression models using Mean Squared Error (MSE) and R-squared scores, complete with comparative scatter plots.

## 🛠️ Technologies Used

*   **Python:** The core programming language for the project.
*   **Scikit-Learn:** Handles dataset loading, data splitting, PCA, kNN, SVM, regression models, and evaluation metrics.
*   **TensorFlow & Keras:** Powers the deep neural network architecture.
*   **SciPy:** Used to run paired t-tests for statistical model comparisons.
*   **Matplotlib & Pandas:** Essential for data visualization and data manipulation.

## 🚀 Setup & Execution

1. Ensure Python 3 is installed on your local machine.
2. Install the required dependencies using pip:
   ```bash
   pip install numpy pandas matplotlib scikit-learn tensorflow scipy
