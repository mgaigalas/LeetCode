// Package movingavgfromdatastream contains solution for LeetCode problem: #346. Moving Average from Data Stream.
package movingavgfromdatastream

// MovingAverage contains buffer (used as a queue) and index of a last element.
type MovingAverage struct {
	buff []int
	idx  int
}

// Constructor creates and returns new instance of MovingAverage.
func Constructor(size int) MovingAverage {
	buff := make([]int, 0, size)
	return MovingAverage{
		buff: buff,
		idx:  0,
	}
}

// Next puts next value into a queue, calculates and returns average of all elements in a queue.
func (this *MovingAverage) Next(val int) float64 {
	if len(this.buff) < cap(this.buff) {
		this.buff = append(this.buff, val)
	} else {
		this.idx = this.idx % cap(this.buff)
		this.buff[this.idx] = val
		this.idx++
	}

	var sum int
	for _, val := range this.buff {
		sum += val
	}

	return float64(sum) / float64(len(this.buff))
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * obj := Constructor(size);
 * param_1 := obj.Next(val);
 */
