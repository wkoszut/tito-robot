#include <Servo.h> 

Servo myservo;  

long distanceCm = 0;

const int TRIG_PIN = 52;
const int ECHO_PIN = 53;

const int SPEED = 210; 

/*************************************************************
Motor Shield 2-Channel DC Motor Demo
by Wojciech Koszut

*************************************************************/
void setup() {  
  myservo.attach(21);  
  myservo.writeMicroseconds(1500);
  //Setup Channel A
  pinMode(12, OUTPUT); //Initiates Motor Channel A pin
  pinMode(9, OUTPUT); //Initiates Brake Channel A pin

  //Setup Channel B
  pinMode(13, OUTPUT); //Initiates Motor Channel B pin
  pinMode(8, OUTPUT);  //Initiates Brake Channel B pin
  
  //dist measure  
  pinMode(TRIG_PIN,OUTPUT);
  pinMode(ECHO_PIN,INPUT);
  
  Serial.begin(9600);  
}

void scanNeutral(){
  myservo.write(90);
  delayMicroseconds(500);
}

void scanLeft(){
  myservo.write(140);
  delay(1000);
  delay(50);
  delayMicroseconds(500);
  checkDistance();
}

void scanRight(){
  myservo.write(40);
  delay(1000);
  delay(50);
  delayMicroseconds(500);
  checkDistance();
}


void stopMotor() {
  Serial.println("Stop motor");
  digitalWrite(9, HIGH);  //Brake for Channel A
  digitalWrite(8, HIGH);  //Brake for Channel B
}

void startMotor() {
  Serial.println("Start motor");
  digitalWrite(12, HIGH); 
  digitalWrite(9, LOW); 
  analogWrite(3, SPEED);   
//  
//  //Motor B backward @ half speed
  digitalWrite(13, HIGH);  
  digitalWrite(8, LOW);   
  analogWrite(11, SPEED);    
}

void turnMotor() {
  Serial.println("Turn motor");
  digitalWrite(12, LOW); 
  digitalWrite(9, LOW); 
  analogWrite(3, SPEED);   
//  
//  //Motor B backward @ half speed
  digitalWrite(13, HIGH);  
  digitalWrite(8, LOW);   
  analogWrite(11, SPEED);    
  
    delay(700); //back
    stopMotor();
}

void checkDistance() {
  long duration;
  digitalWrite(TRIG_PIN, LOW);
  delayMicroseconds(2);
  digitalWrite(TRIG_PIN, HIGH);
  delayMicroseconds(10);
  digitalWrite(TRIG_PIN, LOW);
  duration = pulseIn(ECHO_PIN,HIGH);

  // convert the time into a distance
  distanceCm = duration / 29.1 / 2 ;
 
  if (distanceCm <= 0){
    Serial.println("Out of range");
  }
  else {
    Serial.print(distanceCm);
    Serial.print("cm");
    Serial.println();
  }
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
  
   delay(500); //back
// scanNeutral();
//   scanRight();
//   scanLeft();
//   scanNeutral();
   checkDistance();    
   if (distanceCm < 30) {
      stopMotor(); 
      turnMotor();
   } else {
      startMotor(); 
   }
}


