package wordladder

type args struct {
	beginWord string
	endWord   string
	wordList  []string
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: beginWord = \"hit\", endWord = \"cog\", " +
			"wordList = [\"hot\",\"dot\",\"dog\",\"lot\",\"log\",\"cog\"]",
		args: args{
			beginWord: "hit",
			endWord:   "cog",
			wordList:  []string{"hot", "dot", "dog", "lot", "log", "cog"},
		},
		want: 5,
	},
	{
		name: "case: beginWord = \"hit\", endWord = \"cog\", " +
			"wordList = [\"hot\",\"dot\",\"dog\",\"lot\",\"log\"]",
		args: args{
			beginWord: "hit",
			endWord:   "cog",
			wordList:  []string{"hot", "dot", "dog", "lot", "log"},
		},
		want: 0,
	},
}
