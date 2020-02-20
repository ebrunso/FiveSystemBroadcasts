# FiveSystemBroadcasts

Coding
1. Create an application to use 5 systems broadcasts

2. Create a foreground service with notification. Clicking on the notification will stop the foreground music.
https://androidwave.com/foreground-service-android-example/

3. Create an IntentService to create a list of random objects (The objects should have atleast 4 fields including an image).
 Populate the recyclerView in the same activity which starts the intent service. Pass the data using a broadcast receiver.

4. Use the AlarmManager to send a notification after 5 secs on clicking each list item. The notification should
have the object that was clicked on

5. Complete the work manager code lab:  https://codelabs.developers.google.com/codelabs/android-workmanager/#0




1. What is the difference in an started service and a bound service?
    Started service will run until its task is completed or stopped by the user.
    Bound services will run when bound until it is unbound.

2. Define what a observer/ subscriber relation is.
    The Observer pattern is a one-to-many dependency where many objects (observers) will be notified
    when the observed object (subject) is changed.

3. Define what a client/server relation is.
    The client-server relationship describes the relationship where the client requests data from
    a server, and how the server responds to these requests,  processes and returns data to the
    client.

4. Define each of the HTTP verbs
    POST - Create CRUD operation - Used to create a new resource, including subordinate resources.
        Subordinate resources are bound to a parent.
    GET - Read CRUD operation - Used to retrieve a representation of the called resource.
    PUT - Update/Replace CRUD operation - Used to update a known resource URI with a brand new
    resource.
    PATCH - Update/Modify CRUD operation - Closely resembles the PUT operation, however it contains
    a set of instructions on how to modify an existing resource to make a new one.
    DELETE -  Delete CRUD operation - Used to delete a resource.

5. Describe at least one use for each service (Foreground, Background, Intent, Bound)
    Foreground - Streaming video
    Background - Compacting data storage
    Intent - Used to handle asynchronous requests by clients on demand.
    Bound - When you want to bind a service to an activity synchroniously and return a result
