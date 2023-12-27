// Package simplifypath contains solution for LeetCode problem: #71. Simplify Path.
package simplifypath

import "strings"

// simplifyPath given a string path, which is an absolute path (starting with a slash '/') to a file or directory
// in a Unix-style file system, converts it to the simplified canonical path.
//
//goland:noinspection SpellCheckingInspection
func simplifyPath(path string) string {
	ps := strings.Split(path, "/")
	cmps := make([]string, 0, len(ps))
	for _, cmp := range ps {
		if cmp == "" || cmp == "." {
			continue
		}

		if cmp == ".." {
			if len(cmps) > 0 {
				cmps = cmps[:len(cmps)-1]
			}
			continue
		}
		cmps = append(cmps, cmp)
	}

	var sb strings.Builder
	for _, cmp := range cmps {
		sb.WriteString("/")
		sb.WriteString(cmp)
	}

	if sb.Len() == 0 {
		return "/"
	}
	return sb.String()
}
