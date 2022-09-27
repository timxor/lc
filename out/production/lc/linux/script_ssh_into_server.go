//   file:     script_ssh_into_server.go
//   run:      clear && go build && go run script_ssh_into_server.go
//

package main
import (
    "log"
    "golang.org/x/crypto/ssh"
    "golang.org/x/crypto/ssh/knownhosts"
)

func main() {
  
    // ssh config
    hostKeyCallback, err := knownhosts.New("/Users/tim/.ssh/known_hosts")
    if err != nil {
        log.Fatal(err)
    }
    
    config := &ssh.ClientConfig{
        User: "tcs",
        Auth: []ssh.AuthMethod{
            ssh.Password("meow"),
        },
        HostKeyCallback: hostKeyCallback,
    }
    
    
    // connect ot ssh server
    // imac = 192.168.1.132
    conn, err := ssh.Dial("tcp", "192.168.1.132:22", config)
    if err != nil {
        log.Fatal(err)
    }
    
    var buff bytes.Buffer
    session.Stdout = &buff
    if err := session.Run(“ls -la”); err != nil {
      log.Fatal(err)
    }
    fmt.Println(buff.String())


    defer conn.Close()
}


// file: script_ssh_into_server.go
// run: python script_ssh_into_server.g
// https://linuxhint.com/golang-ssh-examples/
//
// go get golang.org/x/crypto/bcrypt
//
// build: go build
//
// run: chmod +x script_ssh_into_server.go
//      go run script_ssh_into_server.go