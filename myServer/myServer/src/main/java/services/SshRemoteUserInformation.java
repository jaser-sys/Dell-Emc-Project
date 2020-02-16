package services;

import com.jcraft.jsch.*;

public class SshRemoteUserInformation implements UserInfo {
    private final String pwd;//password
    
    public SshRemoteUserInformation (String userName, String password) {
        pwd = password;
    }
    
    @Override
    public String getPassphrase() {
        throw new UnsupportedOperationException("getPassphrase Not supported yet.");
    }
    @Override
    public String getPassword() {
        return pwd;
    }
    @Override
    public boolean promptPassword(String string) {
        return true;
    }
    @Override
    public boolean promptPassphrase(String string) {
        throw new UnsupportedOperationException("promptPassphrase Not supported yet.");
    }
    @Override
    public boolean promptYesNo(String string) {
        return true;
    }
    @Override
    public void showMessage (String string) {
    }
}


