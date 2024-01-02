// Package nextgreaterelementone contains solution for LeetCode problem: #496. Next Greater Element I.
package onlinestockspan

// StockSpanner contains daily price quotes.
type StockSpanner struct {
	stack [][2]int
}

// Constructor creates and returns new instance of StockSpanner.
func Constructor() StockSpanner {
	return StockSpanner{
		stack: make([][2]int, 0),
	}
}

// Next collects daily price quotes for some stock and returns the span of that stock's price for the current day.
func (this *StockSpanner) Next(price int) int {
	days := 1
	for len(this.stack) > 0 && this.stack[len(this.stack)-1][0] <= price {
		days += this.stack[len(this.stack)-1][1]
		this.stack = this.stack[:len(this.stack)-1]
	}
	this.stack = append(this.stack, [2]int{price, days})
	return days
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.Next(price);
 */
