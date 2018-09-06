package com.atomic.recipestorage.util;

import java.text.DecimalFormat;

public class Calculate {
    // default constructor
    public Calculate(){}
    
    // Finds the nutrient total for the ingredient that is displayed in the table
    public static double nutrientTotal(double servingSize, double nutrientValue, double ingredientAmt, String measure) {
        // (1 and 2) convert amount of ingredient in recipe to grams
        double ingredAmtGrams = amountToGrams(ingredientAmt, measure);
        
        // (3) use serving size to find the percentage of each nutrient 
        // that is in the ingredient amount
        double nutrientPercentage = nutrientsPerGram(nutrientValue, servingSize);
        
        // (4) Find the totals for each nutrient that is in the ingredient. This will
        // be displayed in the table. In order to get the totals, use the 
        // percentage of nutrient multiplied by the ingred amt in grams (amtInGrams)
        double nutrientTotal = totalNutrientValueInIngredient(nutrientPercentage, ingredAmtGrams);        
        DecimalFormat df = new DecimalFormat("#.0");
        double result = Double.parseDouble(df.format(nutrientTotal));
        return result;
    }         
    
    // 1) convert amount of ingredient in the recipe to grams 
    // 2) RETURNS gramEquivalent x amount
    public static double amountToGrams(double amount, String measurementType) {
        double gramEquivalent;
        switch (measurementType) {
            case "grams": 
                gramEquivalent = 1;
                break;
            case "liquid oz": 
                gramEquivalent = 30;
                break;
            case "dry oz":
                gramEquivalent = 28;
                break;    
            case "teaspoon":
                gramEquivalent = 5;
                break;
            case "tablespoon":
                gramEquivalent = 15;
                break;
            case "milligram":
                gramEquivalent = 1000;
                break;
            case "liquid cup":
                gramEquivalent = 240;
                break;
            case "dry cup":
                gramEquivalent = 230;
                break;
            case "liquid pint":
                gramEquivalent = 480;
                break;
            case "dry pint":
                gramEquivalent = 460;
                break;
            default:
                gramEquivalent = 1;
                break;
        }        
        double resultD = gramEquivalent * amount;
        DecimalFormat df = new DecimalFormat("#.0");
        double result = Double.parseDouble(df.format(resultD));
        return result;
    }    
    
    // 3)calculate percentage of each nutrient per gram
    // percentageOfNutrientInEachGram = NutrientGramsPerServingOnLabel / GramsPerServing
    public static double nutrientsPerGram(double nutrientValue, double servingSize) {
        double resultD = nutrientValue / servingSize;
        DecimalFormat df = new DecimalFormat("#.0");
        double result = Double.parseDouble(df.format(resultD));
        return result;
    }
    
    // 4) find the total value for each nutrient in each ingredient
    // totalNutrientValueInIngredient = percentageOfNutrientInEachGram x totalNutrientGramsInRecipe
    public static double totalNutrientValueInIngredient(double percentOfNutrient, double amtOfIngredInGrams) {        
        double resultD = percentOfNutrient * amtOfIngredInGrams;
        DecimalFormat df = new DecimalFormat("#.0");
        double result = Double.parseDouble(df.format(resultD));
        return result;
    }

    // 4a) calculate values for each nutrient sum for diplay in ingredient list
    public static double getNutrientSum(double nutrientValue, double servingSize, double amtToGrams) {
        // 4b) calculate percentage of each nutrient per gram
        double percentOfNutrientPerGram = nutrientValue / servingSize;
        // 4c) find the total value sum for each nutrient in each ingredient
        double nutrientValueSum = percentOfNutrientPerGram * amtToGrams;
        DecimalFormat df = new DecimalFormat("#.0");
        double result = Double.parseDouble(df.format(nutrientValueSum));
        return result;        
    }
    
    // 5) find the totals for each nutrient for display in the Nut Label for printing
    // needs to be formated to 1 decimal
    public static double totalNutrientForWholeRecipe(double totalNutrientForIngredient, int numberOfServings){
        double resultD = totalNutrientForIngredient / numberOfServings;
        DecimalFormat df = new DecimalFormat("#.0");
        double result = Double.parseDouble(df.format(resultD));
        return result;
    }
    
    // 6) Find the weight of each servig. The dish must be weighted by the user 
    public static double weightPerServing(double totalGramsOfWholeRecipe, int numberOfServings) {
        double resultD = totalGramsOfWholeRecipe / numberOfServings;
        DecimalFormat df = new DecimalFormat("#.0");
        double result = Double.parseDouble(df.format(resultD));
        return result;
    }
    
    
}
