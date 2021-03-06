#recursively sort an array

def quick_sort(array)
  if array == []
    []
  else
    pivot = array[0]
    left, right = array.drop(1).partition {|x| x <= pivot }
    quick_sort(left) + [pivot] + quick_sort(right)
  end
end

p quick_sort([9,3,7,8,5,4,3,2,1])
p quick_sort([])

