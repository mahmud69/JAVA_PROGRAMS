
import numpy as np    # for scientific computing
import matplotlib.pyplot as plt  # for generic plots
#%matplotlib notebook
X_train = np.array([[1,1], [2,2.5], [3,1.2], [5.5,6.3], [6,9], [7,6]])
Y_train = ['red', 'red', 'red', 'blue', 'blue', 'blue', 'blue']

X_test = np.array ([3,4])

print(X_train [5,0])
print(X_train [5,1])

print(X_train [:,0])
print(X_train [:,1])

plt.figure()
plt.scatter(X_train[:,0], X_train[:,1], s = 170, color = Y_train[:])
plt.scatter(X_test[0], X_test[1], s = 170, color = 'green')
#plt.show()

def dist(x, y):
    return np.sqrt(np.sum((x - y)**2))

num = len(X_train)
distance = np.zeros(num)

for i in range(num):
    distance[i] = dist(X_train[i], X_test)
print (distance)

min_index = np.argmin(distance)
print(Y_train[min_index])

from sklearn import datasets
digits = datasets.load_digits()
print(digits.images[0])

plt.figure()
plt.imshow(digits.images[0], cmap = plt.cm.gray_r, interpolation = 'nearest')
#plt.show()

print (digits.target[0])

X_train = digits.data[0:10]
Y_train = digits.target[0:10]
X_test = digits.data[345]

plt.figure()
plt.imshow(digits.images[345], cmap = plt.cm.gray_r, interpolation = 'nearest')
#plt.show()

num = len(X_train)
no_errors = 0
distance = np.zeros(num)

for j in range (1697, 1797):
    X_test = digits.data[j]
    for i in range(num):
        distance[i] = dist(X_train[i], X_test)
    min_index = np.argmin(distance)
    if Y_train[min_index] != digits.target[j]:
        no_errors += 1
print (no_errors)


X_train = digits.data[0:1000]
Y_train = digits.target[0:1000]
X_test = digits.data[345]

num = len(X_train)
no_errors = 0
distance = np.zeros(num)

for j in range (1697, 1797):
    X_test = digits.data[j]
    for i in range(num):
        distance[i] = dist(X_train[i], X_test)
    min_index = np.argmin(distance)
    if Y_train[min_index] != digits.target[j]:
        no_errors += 1
print (no_errors)