#recursively sort an array

def quick_sort(array)
  pivot = array[0];
  left = [];
  right = [];
  sorted = [];
 #until input is []
  if (array == [])
    []
  else
    array[1..array.length].each do |num|
      if (num <= pivot)
        left << num
      else
        right << num
      end
    end
    sorted << quick_sort(left) 
    sorted << pivot 
    sorted << quick_sort(right)
  end
  sorted.flatten
end

p quick_sort([9,8,7,6,5,4,3,2,1])

