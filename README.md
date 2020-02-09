*********** LyonFutureApiV1*******************


Rest web service api that doing queries in the xml data sets.

Getting Started:
Just clone or download this project.

Prerequisites:
Download apache netbeans(latest) and jdk 13
Port: 8085
Tomcat password (default) is username:admin password:admin


Before running the tomcat, just click build so that all dependencies will be downloaded.



Running test:

You can test it via url or in user interfacce provided.

Before anything else:
Just place the xml file in Documents then create a folder "myxml" then place the xml file there.
Also place rename the xml file to "dummy.xml" inorder to match this in code.



For first service, getByid:

You can append something in the url like this format: http://localhost:8085/searchById/icdvaluehere/enterprisenumberhere/
Addtional view: if you want to display in table just append /table in the stated url above
Ex. http://localhost:8085/searchById/0007/7696250922/table


Second Service: searchByname
You can append something in the url like this format: http://localhost:8085/wildsearch/nametosearch/
For ex: http://localhost:8085/wildSearch/cars/
Addtional view: if you want to display in table just append /table in the stated url above
Ex. http://localhost:8085/wildSearch/unicars/table


Third service: searchByexactName
You can append something in the url like this format: http://localhost:8085/exactSearch/name/
For ex: http://localhost:8085/exactSearch/Unicars/
Addtional view: if you want to display in table just append /table in the stated url above
Ex. http://localhost:8085/exactSearch/Unicars/table



Built With:
Maven
Framework: Spring mvc


Acknowledgments:

Thanks to Randmc Macion who make me borrow his laptop in order to fully implement this task.







