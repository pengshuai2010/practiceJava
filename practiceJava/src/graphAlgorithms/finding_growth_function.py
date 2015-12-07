'''
Created on Dec 6, 2015

@author: speng
'''
import math
if __name__ == '__main__':
    n = [16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384]
    #the square case
    weight = [2.755,3.933,5.494,7.800,10.681,14.869,20.891,29.656,41.763,58.945]
    #the cube case
#     weight = [4.436, 7.100, 11.452, 17.612, 27.684, 43.279, 68.210, 107.611, 168.938, 266.666]
    temp1 = weight[0:len(weight) - 2]
    temp2 = weight[1:len(weight) - 1]
    total = 0
    for i in range(len(weight) - 2):
        total = total + temp2[i]/temp1[i]
    b = total/(len(weight) - 2)
    print 'b = ' + str(b)
    
    total = 0
    for i in range(len(weight)):
        total = total + weight[i]/(pow(b, math.log(n[i], 2)))
    a = total/len(weight)
    print 'a = ' + str(a)
    
    print 'n\tf()'
    for i in n:
        print str(i) + '\t' + str(a*pow(b, math.log(i, 2)))
    
    