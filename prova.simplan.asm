move SP FP  
pushr FP 
move SP AL 
pushr AL 
nullmove AL T1 
subi T1 1
store A0 0(T1) 
pushr A0 
storei A0 1
popr T1 
beq A0 T1 label0
storei A0 0
b label1
label0:
storei A0 1
label1:
halt
