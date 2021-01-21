def MinStartValueSum(arr):
    if len(arr) =0:
        return 0
    minval = 0
    my_sum = 0
    for i in arr:
        my_sum += i
        if(my_sum<0 and abs(my_sum)+1 > minval):
            minval = abs(my_sum) +1
    if minval == 0:
        minval = 1
    return minval