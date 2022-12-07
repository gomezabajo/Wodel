.PS
# Output6.m4
log_init

define(`del',`L_unit*5/2')

dmov = 0.4
# Input labels
C: grid_(0,0)
DE: C+grid_(0,AND_ht*7/4)
A0: DE+grid_(0,BUF_ht*5/2); dot(at A0); "a" rjust at A0
A1: A0+grid_(0,BUF_ht*5/2); dot(at A1); "b" rjust at A1
A2: A1+grid_(0,BUF_ht*5/2); dot(at A2); "c" rjust at A2
  move to (-0.2,0)   # Lettering within the global object

G1: NOT_gate at (A0+grid_(8,BUF_ht*8),A0)

G2: AND_gate at (A1+grid_(24,BUF_ht*24),A1)

G3: NOT_gate at (A2+grid_(8,BUF_ht*8),A2)

line right 3*del from A0 to G1.In1
line right 3*del from A1 to G2.In1
line right 3*del from G1.Out to G2.In2
line right 3*del from A2 to G3.In1

H1: AND_gate at (G2+grid_(40,BUF_ht*40),G2+grid_(0,BUF_ht*15/13))

line right 3*del from G2.Out to H1.In2
line right 3*del from G3.Out to H1.In1

LOUT: line right del from H1.Out; dot at (LOUT,Here); move right 0.2; "f" rjust

.PE