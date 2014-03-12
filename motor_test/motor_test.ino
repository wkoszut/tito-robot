/*************************************************************
Motor Shield 2-Channel DC Motor Demo
by Wojciech Koszut

*************************************************************/
void setup() {  
  //Setup Channel A
  pinMode(12, OUTPUT); //Initiates Motor Channel A pin
  pinMode(9, OUTPUT); //Initiates Brake Channel A pin

  //Setup Channel B
  pinMode(13, OUTPUT); //Initiates Motor Channel B pin
  pinMode(8, OUTPUT);  //Initiates Brake Channel B pin
  
  Serial2.begin(9600);  
  
}

void loop(){
//  //Motor A forward @ half speed
//  digitalWrite(12, HIGH); 
//  digitalWrite(9, LOW);   
//  analogWrite(3, 123);   
//  
//  //Motor B backward @ half speed
//  digitalWrite(13, HIGH);  
//  digitalWrite(8, LOW);   
//  analogWrite(11, 123);    
//  
//  delay(3000); //forward for 3000 ms
//  
//  digitalWrite(9, HIGH);  //Brake for Channel A
//  digitalWrite(8, HIGH);  //Brake for Channel B
//
//  delay(1000); //wait one sec
//
//  //Motor A backward @ half speed
//  digitalWrite(12, LOW); 
//  digitalWrite(9, LOW);  
//  analogWrite(3, 123);   
//
//  //Motor B backward @ half speed
//  digitalWrite(13, LOW); 
//  digitalWrite(8, LOW);  
//  analogWrite(11, 123);  

 Serial2.write(45);
  
 delay(3000); //back
}
