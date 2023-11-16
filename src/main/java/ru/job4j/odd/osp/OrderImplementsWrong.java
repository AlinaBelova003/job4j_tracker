package ru.job4j.odd.osp;

/**
 * Нарушение принципа - ОСР
 * Здесь нельзя наследоваться, т.к хоть PhoneOrder и OnlineOrder оба класса относятся к доставке и оба могут записывать заказ,
 * они имеют разное количество характеристик, заказ через телефон не является онлайн заказом.
 * Надо выделять интерфейс и создавать новые отдельные сущности PhoneOrder, OnlineOrder
 */
public class OrderImplementsWrong {

    public static class PhoneOrder {
        private String product;
        private int articleNumber;
        private int numberCustomer;
        private String employee;

        public PhoneOrder(String product, int articleNumber, int numberCustomer, String employee) {
            this.product = product;
            this.articleNumber = articleNumber;
            this.numberCustomer = numberCustomer;
            this.employee = employee;
        }

        public void proses() {
            System.out.println("Обработка заказа:" + product + "артикль:" + articleNumber + " заказчик: " + numberCustomer);
        }
    }

    public static class OnlineOrder extends PhoneOrder {

        private String mail;

        public OnlineOrder(String product, int articleNumber, int numberCustomer, String mail, String employee) {
            super(product, articleNumber, numberCustomer, employee);
            this.mail = mail;
        }

        @Override
        public void proses() {
            System.out.println("Обработка заказа для онлайн доставки");
        }
    }

}
