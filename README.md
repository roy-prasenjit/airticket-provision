# airticket-provision

<p>FeelFlyFree Ticket book agency focus the Indian travel market It swiftly became the favored choice for organizing both business and leisure trips to India, providing its customers with efficient and reliable 
travel services while offering the best deals and the most innovative products in the industry.<p>

######As given in the testcase, the application uses J2EE technology to perform the task
***
### Tech
airticket-provision uses the following technologies

> servlets - Controllers to handle dynamic changing data
> JSPs - Handles client end information and UI rendering
> Oracle Database
> html,css and validation scripts are embedded in the jsps.

### Schema Information
#### Tables
| Tables        | Primary Key   |  type        | Foreign Keys |
| ------------- |:-------------:| -----------:| ----------:|
| OARUSER    | EMAIL  | VARCHAR2(50) | - |
| OARUSERDETAILS     | REGISTRATIONID  | NUMBER | EMAIL REFERENCES OARUSER(EMAIL) |
| OARFLIGHTS     | FLIGHTID   |   VARCHAR2(10)) | - |
| TRNX     | TRANX   |   VARCHAR2(50)) | USEREMAIL REFERENCES OARUSER(EMAIL), FLIGHTID REFERENCES OARFLIGHTS(FLIGHTID) |
| (?)OARBOOKINGDETAILS  | FLIGHTID, SEATNUMBER | *composite* | TID CONSTRAINT OARBOOKINGDETAILS_FK FOREIGN KEY (TID) ,  FLIGHTID REFERENCES OARFLIGHTS(FLIGHTID) |

### Packages and info 

  - Beans: Conains POJO classes wrt the Database model;
  - Controllers: Contains servlets to handle Request Response cycle. 
  - DAO: The Data access objects represent the model portion of the system. 
  - Services: A services layers is added to de-couple controler-DAO handshake. 


### Future

 - Admin panel
 - JQuery Fetches

License
----

MIT
