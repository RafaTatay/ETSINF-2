          .globl __start
          .text 0x00400000

__start:
          li $s0, 0
loop:
	      li $s0, 1
		  li $v0, 1
		  li $a0, $s0 
		  li $v0, 11
		  li $a0 , '>'
		  syscall
          li $v0,5
          syscall
		  beqz $v0, exit
		  addi $s0, $s0, 1
          addu $s0,$s0,$v0
          li $v0,11
          li $a0, '\n'
          syscall
          b loop 

exit:     li $v0, 11
		  li $a0 , '='
		  move $a0, $s0
		  li $v0, 1
		  syscall
		  li $v0,10
          syscall
