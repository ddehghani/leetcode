
x = [x / 5.0 for x in range(6)]
y = [1]
h = 0.2
def f(x,y):
    return -4 * x * y
for i in range(1,6,1):
    print( f"y(x{i}) = y(x{i - 1} + h) = y(x{i-1}) + hf(x{i-1}, y(x{i-1}))")
    y.append(y[i-1] + h * f(x[i-1], y[i-1]))
    print( f"y(x{i}) = y({x[i]})= y({x[i-1]} + {h}) = {y[i-1]} + {h * f(x[i-1], y[i-1])} = {y[i]}")