package queststore.controller;

import java.util.List;

import queststore.model.*;

public class AdminController {

    public AdminController() {
    }

    private String getDataFromGetInput(String text) {
        InputController inputController = new InputController();
        String data = inputController.getStringInput(text);
        return data;
    }

    public GroupModel selectGroup() {
        // List<GroupModel> allGroups = AdminModel.getGroupList();
        return new GroupModel("A");

    }

    public void createMentor() {
        String mentorName = getDataFromGetInput("Enter mentor name: ");
        String mentorLastName = getDataFromGetInput("Enter mentor last name: ");
        String mentorEmail = getDataFromGetInput("Enter mentor email: ");
        String mentorPassword = getDataFromGetInput("Enter mentor password: ");
        GroupModel group = selectGroup();
        MentorModel newMentor = new MentorModel(mentorName, mentorLastName, mentorEmail, mentorPassword, group);
    }

    public void createGroup() {
        String groupName = getDataFromGetInput("Enter group name: ");
        GroupModel newGroup = new GroupModel(groupName);
    }
}