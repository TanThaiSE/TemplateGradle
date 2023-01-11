FROM gcr.io/honto-development/honto/java:8u92

MAINTAINER Seiya Kobayashi <seiya.kobayashi@2dfacto.co.jp>

ENV project_name honto-api-member

ADD honto-api-member.zip /opt/honto-api-member.zip
ADD ./*.sh /usr/local/bin/
ADD ./newrelic /opt/newrelic

RUN unzip /opt/honto-api-member.zip -d /opt
RUN rm /opt/honto-api-member.zip

VOLUME ["/var/log/api/member"]
VOLUME ["/var/logs"]
VOLUME ["/home/honto/member/config"]

HEALTHCHECK --interval=1m --timeout=30s --retries=3 CMD /usr/local/bin/healthcheck.sh

CMD /usr/local/bin/endpoint.sh

EXPOSE 8080

