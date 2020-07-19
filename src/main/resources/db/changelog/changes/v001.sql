CREATE TABLE job.jobs (
                    "job_id" varchar NOT NULL,
                    "job_name" varchar NOT NULL,
                    "run_date" date NULL,
                    CONSTRAINT job_id_pk PRIMARY KEY ("job_id")
                );

INSERT INTO job.jobs (
                    "job_id",
                    "job_name",
                    "run_date"
                ) VALUES (
                    'job_001_20200718',
                    'test_job',
                    '2020-07-18'
                );

