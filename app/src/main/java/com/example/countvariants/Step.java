package com.example.countvariants;

public class Step {
    private int StepOne;
    private int StepTwo;

    public Step(int stepone,int steptwo){
        this.StepOne = stepone;
        this.StepTwo = steptwo;
    }


    public int getStepOne() {
        return StepOne;
    }

    public void setStepOne(int stepOne) {
        StepOne = stepOne;
    }

    public int getStepTwo() {
        return StepTwo;
    }

    public void setStepTwo(int stepTwo) {
        StepTwo = stepTwo;
    }
}
