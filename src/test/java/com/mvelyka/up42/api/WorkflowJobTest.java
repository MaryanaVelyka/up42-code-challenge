package com.mvelyka.up42.api;

import com.mvelyka.up42.api.client.AuthClient;
import com.mvelyka.up42.api.client.JobClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.util.Strings;

public class WorkflowJobTest {

    @Test
    public void getJobStatusTest() {
        AuthClient authClient = new AuthClient();
        String token = authClient.createToken();

        JobClient jobClient = new JobClient();
        String id = jobClient.createAndRunJob(token);

        String status = jobClient.getJobStatus(id, token);
        Assert.assertFalse(Strings.isNullOrEmpty(status));

    }
}
