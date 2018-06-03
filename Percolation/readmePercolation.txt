/******************************************************************************
 *  Name: Arthur Ryuichi Yamashiro Kubagawa    
 *  NetID:    8589843
 *  Precept:  EP02 - Percolation
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 * 
 *  Operating system: Linux - Ubuntu
 *  Compiler: javac
 *  Text editor / IDE: emacs
 *
 *  Have you taken (part of) this course before:
 *  Have you taken (part of) the Coursera course Algorithm, Part I:
 *
 *  Hours to complete assignment (optional):
 *
 ******************************************************************************/

Programming Assignment 1: Percolation


/******************************************************************************
 *  Describe how you implemented Percolation.java. How did you check
 *  whether the system percolates?
 *****************************************************************************/
 Implementei o Percolation.java com uma matriz boolean[][] para mostrar quais sitios estao abertos, alguns ints para contagem e uma WeightedQuickUnionFind. Para checar se o sistema percola, testo se algum dos sitios do fundo(bottom) esta conectado a algum dos sitios do topo.


/******************************************************************************
 *  Perform computational experiments to estimate the running time of
 *  PercolationStats.java for values values of n and T when implementing
 *  Percolation.java with QuickFindUF.java.
 *
 *  To do so, fill in the two tables below. Each table must have 4-10
 *  data points, ranging in time from around 0.25 seconds for the smallest
 *  data point to around 30 seconds for the largest one. Do not include
 *  data points that takes less than 0.1 seconds.
 *****************************************************************************/

(keep T constant)

 n          time (seconds)
------------------------------
50		.273		
75		.572
100		1.023
200		5.308
400		44.657



(keep n constant)

 T          time (seconds)
------------------------------
50		.333
75		.373
100		.43
200		.704
400		1.351


/******************************************************************************
 *  Using the empirical data from the above two tables, give a formula 
 *  (using tilde notation) for the running time (in seconds) of
 *  PercolationStats.java as function of both n and T, such as
 *
 *       ~ 5.3*10^-8 * n^5.0 * T^1.5
 *
 *  Recall that with tilde notation, you include both the coefficient
 *  and exponents of the leading term (but not lower-order terms).
 *  Round each coefficient to two significant digits.
 *
 *****************************************************************************/

QuickFindUF running time (in seconds) as a function of n and T:  ~ 


/******************************************************************************
 *  Repeat the previous two questions, but using WeightedQuickUnionUF
 *  (instead of QuickFindUF).
 *****************************************************************************/

(keep T constant)

 n         time (seconds)
------------------------------
...
...
...
...
...


(keep n constant)

 T          time (seconds)
------------------------------
...
...
...
...
...


WeightedQuickUnionUF running time (in seconds) as a function of n and T:  ~ 



 

/**********************************************************************
 *  How much memory (in bytes) does a Percolation object (which uses
 *  WeightedQuickUnionUF.java) use to store an N-by-N grid? Use the
 *  64-bit memory cost model from Section 1.4 of the textbook and use
 *  tilde notation to simplify your answer. Briefly justify your answers.
 *
 *  Include the memory for all referenced objects (deep memory).
 **********************************************************************/

/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/




/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *****************************************************************************/


/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/
/******************************************************************************
 *  Name:     
 *  NetID:    
 *  Precept:  
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 * 
 *  Operating system:
 *  Compiler:
 *  Text editor / IDE:
 *
 *  Have you taken (part of) this course before:
 *  Have you taken (part of) the Coursera course Algorithm, Part I:
 *
 *  Hours to complete assignment (optional):
 *
 ******************************************************************************/

Programming Assignment 1: Percolation


/******************************************************************************
 *  Describe how you implemented Percolation.java. How did you check
 *  whether the system percolates?
 *****************************************************************************/



/******************************************************************************
 *  Perform computational experiments to estimate the running time of
 *  PercolationStats.java for values values of n and T when implementing
 *  Percolation.java with QuickFindUF.java.
 *
 *  To do so, fill in the two tables below. Each table must have 4-10
 *  data points, ranging in time from around 0.25 seconds for the smallest
 *  data point to around 30 seconds for the largest one. Do not include
 *  data points that takes less than 0.1 seconds.
 *****************************************************************************/

(keep T constant)

 n          time (seconds)
------------------------------
...
...
...
...
...
...


(keep n constant)

 T          time (seconds)
------------------------------
...
...
...
...
...
...
...


/******************************************************************************
 *  Using the empirical data from the above two tables, give a formula 
 *  (using tilde notation) for the running time (in seconds) of
 *  PercolationStats.java as function of both n and T, such as
 *
 *       ~ 5.3*10^-8 * n^5.0 * T^1.5
 *
 *  Recall that with tilde notation, you include both the coefficient
 *  and exponents of the leading term (but not lower-order terms).
 *  Round each coefficient to two significant digits.
 *
 *****************************************************************************/

QuickFindUF running time (in seconds) as a function of n and T:  ~ 


/******************************************************************************
 *  Repeat the previous two questions, but using WeightedQuickUnionUF
 *  (instead of QuickFindUF).
 *****************************************************************************/

(keep T constant)

 n         time (seconds)
------------------------------
...
...
...
...
...


(keep n constant)

 T          time (seconds)
------------------------------
...
...
...
...
...


WeightedQuickUnionUF running time (in seconds) as a function of n and T:  ~ 



 

/**********************************************************************
 *  How much memory (in bytes) does a Percolation object (which uses
 *  WeightedQuickUnionUF.java) use to store an N-by-N grid? Use the
 *  64-bit memory cost model from Section 1.4 of the textbook and use
 *  tilde notation to simplify your answer. Briefly justify your answers.
 *
 *  Include the memory for all referenced objects (deep memory).
 **********************************************************************/

/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/




/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *****************************************************************************/


/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/


Tive dificuldades inicialmente para organizar como a WeightedQuickUnionFind se encaixaria
no Percolation, e em dado momento estava usando a função de Find ao invés de Connected na
função percolates(), o que estava levando a alguns erros. Não consegui diminuir o tempo de
execução da função.


/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/
Gostei da tarefa, e acho particularmente interessante (nao apenas nesta tarefa, mas em todas) a
questão de modularização, de ter classes diferentes trabalhando em conjunto. Acho incrível quando
funcionam.
