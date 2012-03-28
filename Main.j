
.class public main
.super java/lang/Object
.method public static main([Ljava/lang/String;)V
.limit locals 2
.limit stack 5



ldc 7.0
ldc 3.0
fmul
ldc -1.0
fadd
fstore 0


getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "var d is equal to"
invokestatic java/lang/String/valueOf(F)Ljava/lang/String;
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V


getstatic java/lang/System/out Ljava/io/PrintStream;
fload 0
invokestatic java/lang/String/valueOf(F)Ljava/lang/String;
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V


ldc 9.0
fstore 0


getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "now it is"
invokestatic java/lang/String/valueOf(F)Ljava/lang/String;
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V


getstatic java/lang/System/out Ljava/io/PrintStream;
fload 0
invokestatic java/lang/String/valueOf(F)Ljava/lang/String;
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

return
.end method
