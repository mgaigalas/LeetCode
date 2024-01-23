package minimumgeneticmutation

type args struct {
	startGene string
	endGene   string
	bank      []string
}

var testCases = []struct {
	name string
	args args
	want int
}{
	{
		name: "case: startGene = \"AACCGGTT\", endGene = \"AACCGGTA\", bank = [\"AACCGGTA\"]",
		args: args{
			startGene: "AACCGGTT",
			endGene:   "AACCGGTA",
			bank:      []string{"AACCGGTA"},
		},
		want: 1,
	},
	{
		name: "case: startGene = \"AACCGGTT\", endGene = \"AAACGGTA\", bank = [\"AACCGGTA\",\"AACCGCTA\",\"AAACGGTA\"]",
		args: args{
			startGene: "AACCGGTT",
			endGene:   "AAACGGTA",
			bank:      []string{"AACCGGTA", "AACCGCTA", "AAACGGTA"},
		},
		want: 2,
	},
}
