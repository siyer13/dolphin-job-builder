package com.dolphin.jobbuilder.service


import com.dolphin.jobbuilder.ms.Job
import com.dolphin.jobbuilder.ms.JobSubmit
import com.dolphin.jobbuilder.repository.JobRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import spock.lang.Specification
import spock.lang.Unroll

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class JobServiceImplSpec extends Specification {

    @Autowired
    private JobRepository jobRepository;

    private JobServiceImpl jobServiceImpl;


    @Unroll
    def "Test submit job"() {

        given:
        jobServiceImpl = new JobServiceImpl(jobRepository:  jobRepository)
        JobSubmit jobSubmit = new JobSubmit()
        jobSubmit.jobName = "Testing first job"

        when:
        Job job = jobServiceImpl.submitJob(jobSubmit)

        then:
        job.jobName == jobSubmit.jobName
        job.jobId != null
        println job.jobId
    }


    @Unroll
    def "test get job"() {

        given:
        jobServiceImpl = new JobServiceImpl(jobRepository:  jobRepository)
    }

}
