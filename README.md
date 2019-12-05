 ## Tello_Drone System


### 1. New functionality: load missions from JSON file in Flier Module.
* Apart from typing missions on the command line, the software can also load missions from JSON file automatically. The Import Componnet is designed by the strategy pattern such that new load method, like read from XML or CSV, can be easily pluged in.

### 2. Improve modularity and encapsulation in Message component.
* Factory Method Pattern is used to create message object instead of creating message object in Message componnet directly, greatly loosing the coupling between Message class and its subclass. It is also good for extensibility if new message type comes.
* The constructors of all kinds of message (except status) and create method in the message factory are encapsulated as protected, in this way, users can only use the decode method to create the message.
* The static method getKeyWord is used to express the key words in the specification, such that it is easier to modify the words if the specification change.

### 3. Make sure that there is only one Dronestate object in the system.
* Singleton pattern is applied in the Dronestate component.
* Avoid pass Dronestate object through multiple levels.

### 4. Separated Action component from Mission component.
* Suppose the specification of the drone will change so often in future, Action component is separated from Mission componnet according to the Ecapsulate What Varies pratice. It is good for tesability, maintainability and extensibility.
* Template Method Pattern is applied in Action component. It is good for reusability.   
* Factory Method Pattern is also used in Action component, greatly loosing the coupling between Action and Mission component.
* We encapsulate constructor of all kinds of actions as protected, so users can only use create method in the factory to create actions.
* Separated the specification language in the factory such that our own language in the software not affected by the change of specification.

### 5. Applying ArrayList to store the missions.
* Iterator Pattern can be used such that decreasing coupling between user and array storage.

