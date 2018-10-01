set ns [new Simulator]
set nf [open tcp.nam w]
$ns namtrace-all $nf

set tf [open tcp.tr w]
$ns trace-all $tf

proc finish { } {
global ns nf tf
$ns flush-trace
close $nf
close $tf
exec nam tcp.nam &
exit 0
}

set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]
set n3 [$ns node]
$n3 label “destination”

$ns duplex-link $n0 $n2 10Mb 1ms DropTail
$ns duplex-link $n1 $n2 10Mb 1ms DropTail
$ns duplex-link $n2 $n3 10Mb 1ms DropTail


set tcp0 [new Agent/TCP]
$ns attach-agent $n0 $tcp0

set ftp0 [new Application/FTP]
$ftp0 set packet_Size_ 500
$ftp0 set interval_ 0.005
$ftp0 attach-agent $tcp0

set tcp1 [new Agent/TCP]
$ns attach-agent $n1 $tcp1

set ftp1 [new Application/FTP]
$ftp1 set packet_Size_ 500
$ftp1 set interval_ 0.005
$ftp1 attach-agent $tcp1

set sink0 [new Agent/TCPSink]
$ns attach-agent $n3 $sink0

set sink1 [new Agent/TCPSink]
$ns attach-agent $n3 $sink1

$ns connect $tcp0 $sink0
$ns connect $tcp1 $sink1


$ns at 0.1 "$ftp1 start"
$ns at 0.1 "$ftp0 start"
$ns at 5 "finish"
$ns run
