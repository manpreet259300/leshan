/*
 * Copyright (c) 2013, Sierra Wireless
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright notice,
 *       this list of conditions and the following disclaimer in the documentation
 *       and/or other materials provided with the distribution.
 *     * Neither the name of {{ project }} nor the names of its contributors
 *       may be used to endorse or promote products derived from this software
 *       without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package leshan.server.lwm2m.client;

import java.net.InetAddress;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.lang.Validate;

/**
 * A LW-M2M client registered on the server
 */
public class ClientUpdate {

    private static final long DEFAULT_LIFETIME_IN_SEC = 86400L;

    private static final String DEFAULT_LWM2M_VERSION = "1.0";

    private InetAddress address;

    private int port;

    private long lifeTimeInSec;

    private String smsNumber;

    private String lwM2mVersion;

    private BindingMode bindingMode;

    private final String registrationId;

    private final String[] objectLinks;

    public ClientUpdate(String registrationId, InetAddress address, int port) {
        this(registrationId, address, port, null, null, null, null, null);
    }

    public ClientUpdate(String registrationId, InetAddress address, int port, String lwM2mVersion, Long lifetime,
            String smsNumber, BindingMode binding, String[] objectLinks) {
        this(registrationId, address, port, lwM2mVersion, lifetime, smsNumber, binding, objectLinks, null);
    }

    public ClientUpdate(String registrationId, InetAddress address, int port, String lwM2mVersion, Long lifetime,
            String smsNumber, BindingMode binding, String[] objectLinks, Date registrationDate) {

        Validate.notEmpty(registrationId);
        this.registrationId = registrationId;
        this.address = address;
        this.port = port;
        this.objectLinks = objectLinks;
        this.lifeTimeInSec = lifetime == null ? DEFAULT_LIFETIME_IN_SEC : lifetime;
        this.lwM2mVersion = lwM2mVersion == null ? DEFAULT_LWM2M_VERSION : lwM2mVersion;
        this.bindingMode = binding == null ? BindingMode.U : binding;
        this.smsNumber = smsNumber;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public InetAddress getAddress() {
        return address;
    }

    public int getPort() {
        return port;
    }

    public String[] getObjectLinks() {
        return objectLinks;
    }

    public long getLifeTimeInSec() {
        return lifeTimeInSec;
    }

    public String getSmsNumber() {
        return smsNumber;
    }

    public String getLwM2mVersion() {
        return lwM2mVersion;
    }

    public BindingMode getBindingMode() {
        return bindingMode;
    }

    public void setAddress(InetAddress address) {
        this.address = address;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setLifeTimeInSec(long lifeTimeInSec) {
        this.lifeTimeInSec = lifeTimeInSec;
    }

    public void setSmsNumber(String smsNumber) {
        this.smsNumber = smsNumber;
    }

    public void setLwM2mVersion(String lwM2mVersion) {
        this.lwM2mVersion = lwM2mVersion;
    }

    public void setBindingMode(BindingMode bindingMode) {
        this.bindingMode = bindingMode;
    }

    @Override
    public String toString() {
        return "ClientUpdate [address=" + address + ", port=" + port + ", lifeTimeInSec=" + lifeTimeInSec
                + ", smsNumber=" + smsNumber + ", lwM2mVersion=" + lwM2mVersion + ", bindingMode=" + bindingMode
                + ", registrationId=" + registrationId + ", objectLinks=" + Arrays.toString(objectLinks) + "]";
    }
}
