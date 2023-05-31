move SP FP  
pushr FP 
move SP AL 
pushr AL 
storei A0 3
pushr A0 
storei A0 7
pushr A0 
storei A0 99
pushr A0 
move AL T1 
subi T1 1
store A0 0(T1) 
pushr A0 
storei A0 1
popr T1 
add A0 T1 
popr A0 
pushr A0 
move AL T1 
subi T1 4
store A0 0(T1) 
halt
