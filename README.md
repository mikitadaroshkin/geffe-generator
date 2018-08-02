# Geffe generator

### Description
Geffe generator in an example of nonlinear feedback shift register system. Linear feedback shift registers are unsafe because they have relatively small
linear complexity, and hence a relatively small fragment of the key streams (LFSR
sequence) can be used to obtain the entire sequence by solving a set of linear
equations. To increase the linear complexity of LFSR, one or more output sequences
of LFSR's are combined with some nonlinear function to produce relatively high
linear complexity. Geffe generator is composed of three LFSRs of distinct lengths combined by nonlinear function f(x1, x2, x3) = x1x2 + x2x3 + x3.

### Usage
Geffe generator is implemented in Java. Main class contains simple test that uses result.txt file to compare result sequences. To use this implementation just compile source code using any major Java compiler (javac, GNU, Eclipse). 

### Todo
* make
* Testing
