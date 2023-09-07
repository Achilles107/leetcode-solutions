package stack;


import java.util.Stack;

public class OnlineStockSpan {
    class StockSpanner {

        class Stock {
            public int price;
            public int days;

            public Stock(int price, int days) {
                this.price = price;
                this.days = days;
            }
        }

        private Stack<Stock> stocks;

        public StockSpanner() {
            stocks = new Stack<>();
        }

        public int next(int price) {
            Stock newPrice = new Stock(price, 0);
            if (this.stocks.isEmpty()) {
                newPrice.days += 1;
                this.stocks.push(newPrice);
            } else {
                while (!this.stocks.isEmpty() && newPrice.price >= this.stocks.peek().price) {
                    Stock nextNode = this.stocks.pop();
                    newPrice.days += nextNode.days;
                }
                newPrice.days += 1;
                this.stocks.push(newPrice);
            }
            return newPrice.days;
        }
    }

    public static void main(String[] args) {

    }
}
