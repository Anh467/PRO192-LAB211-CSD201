package exception;

public class CheckWebAddress {
    private final String webPattern = "^(https://)?([\\w-]+\\.)+[\\w]+(/[\\w-./?%=]*)?$";
    public String checkWebAddress(String web) throws WebAddressException {
        if (!web.matches(webPattern)) throw new WebAddressException("Invalid web address!");
        return web;
    }
}
