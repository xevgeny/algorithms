/*

https://www.hackerrank.com/challenges/mini-max-sum/problem

Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers.
Then print the respective minimum and maximum values as a single line of two space-separated long integers.

*/

package main

import (
	"bufio"
	"fmt"
	"io"
	"os"
	"strconv"
	"strings"
)

// Complete the miniMaxSum function below.
func miniMaxSum(arr []int32) {
	var lo int32 = arr[0]
	var hi int32 = arr[0]

	var sum int64 = 0
	for _, i := range arr {
		if i < lo {
			lo = i
		} else if i > hi {
			hi = i
		}
		sum += int64(i)
	}

	fmt.Printf("%d %d", sum-int64(hi), sum-int64(lo))
}

func main() {
	reader := bufio.NewReaderSize(os.Stdin, 1024*1024)

	arrTemp := strings.Split(readLine(reader), " ")

	var arr []int32

	for i := 0; i < 5; i++ {
		arrItemTemp, err := strconv.ParseInt(arrTemp[i], 10, 64)
		checkError(err)
		arrItem := int32(arrItemTemp)
		arr = append(arr, arrItem)
	}

	miniMaxSum(arr)
}

func readLine(reader *bufio.Reader) string {
	str, _, err := reader.ReadLine()
	if err == io.EOF {
		return ""
	}

	return strings.TrimRight(string(str), "\r\n")
}

func checkError(err error) {
	if err != nil {
		panic(err)
	}
}
