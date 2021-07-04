package com.aaryan11hash.chatservice.Events.RabbitQueueService;

import com.aaryan11hash.chatservice.AppUtils.Converter;
import com.aaryan11hash.chatservice.Config.RabbitMqConfig;
import com.aaryan11hash.chatservice.Events.Models.BlobFileMessageEvent;
import com.aaryan11hash.chatservice.Web.Model.BlobFileMessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMqPublisherImpl implements RabbitMqPublisher{

    private final RabbitTemplate rabbitTemplate;


    @Override
    public void publishBlobForProcess(BlobFileMessageEvent blobFileMessageEvent) {

        rabbitTemplate.convertAndSend(RabbitMqConfig.TEST_EXCHANGE,RabbitMqConfig.BLOB_PROCESS_QUEUE,blobFileMessageEvent);

    }


}
