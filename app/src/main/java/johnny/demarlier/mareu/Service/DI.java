package johnny.demarlier.mareu.Service;


/**
 * Dependency injector to get instance of services
 */

public class DI {
    private static MeetingApiService service = new DummyMeetingApiService();


    public static MeetingApiService getMeetingApiService() {
        return service;
    }


}
