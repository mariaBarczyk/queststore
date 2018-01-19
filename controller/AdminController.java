package queststore.controller;

import queststore.model.MentorModel;

public class AdminController {

    public void createMentor() {
        String mentorName = getDataFromGetInput("Enter mentor name: ");
        String mentorLastName = getDataFromGetInput("Enter mentor last name: ");
        String mentorEmail = getDataFromGetInput("Enter mentor email: ");
        String mentorPassword = getDataFromGetInput("Enter mentor password: ");
        MentorModel newMentor = new MentorModel(mentorName, mentorLastName, mentorEmail, mentorPassword);
    }

    private String getDataFromGetInput(String text) {
        InputController inputController = new InputController();
        String data = inputController.getStringInput(text);
        return data;
    }
}