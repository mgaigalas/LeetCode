// Package minimumgeneticmutation contains solution for LeetCode problem: #433. Minimum Genetic Mutation.
package minimumgeneticmutation

// minMutation given the two gene strings startGene and endGene and the gene bank, returns the
// minimum number of mutations needed to mutate from startGene to endGene. If there is no such a mutation, return -1.
func minMutation(startGene string, endGene string, bank []string) int {
	queue := make([]string, 1, len(bank))
	queue[0] = startGene
	seen := make(map[string]struct{}, len(bank))
	seen[startGene] = struct{}{}

	var mutationCount int
	for len(queue) > 0 {
		levelSize := len(queue)
		for ; levelSize > 0; levelSize-- {
			gene := queue[0]
			queue = queue[1:]
			if gene == endGene {
				return mutationCount
			}

			for _, validGene := range bank {
				if _, exists := seen[validGene]; !exists && countDiffs(gene, validGene) == 1 {
					seen[validGene] = struct{}{}
					queue = append(queue, validGene)
				}
			}
		}
		mutationCount++
	}
	return -1
}

func countDiffs(source string, target string) int {
	var diffCount int
	for i := 0; i < len(source); i++ {
		if source[i] == target[i] {
			continue
		}
		diffCount++
	}
	return diffCount
}
