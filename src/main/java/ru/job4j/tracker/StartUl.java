package ru.job4j.tracker;

public class StartUl {
    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        String[] menu = {
                "Add new Item", "Show new items", "Edit item",
                "Delete item", "Find item by id", "Find items by name",
                "Exit Program"
        };
         for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[]args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(), new AllItemAction(),
                new EditAction(), new DeleteAction(),
                new FindIdAction(), new FindNameAction(), new Exit()
        };
        new StartUl().init(input, tracker, actions);
    }
}
