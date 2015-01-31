# 1234 * 5678
# a = 12, b = 34, c = 56, d = 78
# x * y = 10**n * ac + 10**n/2 * (a*d + b*c) + b*d
# 1.recursively compute ac, 
# 2. bd
# 3. recursively compute (a+b)(c+d) = ac +ad + bc +bd
# gosses trick 3 - 1 - 2 = ad +bc
# summary 3 recursive mults and some additions
# what is the base case?
#
=begin
mult( a, b ) returns a multiplied by b
if a==0 mult( a, b ) = 0
if a==1 mult( a, b ) = b
otherwise mult( a, b ) = mult( a-1, b ) + b 
=end

=begin
Grades_chool
[1,2,3,4,5,6,7,8].inject(*:) or 
  for each num in array a = [1,2,3,4],mult by each num
    in aray b= [5,6,7,8]
=end

#how to recursively compute a*c? 
#12 * 56? --num1 added to by itself num2 times
#def recur_add(n,times)
#if times = 0
#  0
#else
#  return n + recur_add(n,times-1)
#
#  recur_add _, 0 = 0
#  recur_add n, times = n + recur_add n, times - 1
#
# def _recur_add(n, times, result)
#   if times == 0
#     return result
#   else
#     return recur_add(n, times - 1, result + n)
#
# def recur_add(n, times)
#   return _recur_add(n, times, 0)
#
#
#
# recur_add(17, 3)
# 17 + recur_add(17, 2)            -- keep this on the stack
#      17 + recur_add(17, 1)       -- "
#           17 + recur_add(17, 0)  -- "
#                0
#
# recur_add(17, 3, 0)
# recur_add(17, 2, 17)
# recur_add(17, 1, 34)
# recur_add(17, 0, 51)
# 51
