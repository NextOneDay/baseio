package com.gifisan.nio.jms.server;

import java.util.ArrayList;
import java.util.List;

import com.gifisan.nio.Attachment;
import com.gifisan.nio.component.ActiveAuthority;

public class JMSSessionAttachment implements Attachment {

	private MQContext				context				= null;
	private TransactionSection		transactionSection		= null;
	private ActiveAuthority			authority				= null;
	private List<String>			queueNames			= new ArrayList<String>();
	private List<Consumer>			consumers				= new ArrayList<Consumer>();
	private ConsumerPushHandle	consumerPushFailedHandle	= null;

	public JMSSessionAttachment(MQContext context) {
		this.context = context;
		this.consumerPushFailedHandle = context.getConsumerPushFailedHandle();
	}

	public TransactionSection getTransactionSection() {
		return transactionSection;
	}

	public void setTransactionSection(TransactionSection transactionSection) {
		this.transactionSection = transactionSection;
	}

	public MQContext getContext() {
		return context;
	}

	public void addQueueName(String queueName) {
		this.queueNames.add(queueName);
	}

	public List<String> getQueueNames() {
		return queueNames;
	}

	public ActiveAuthority getAuthority() {
		return authority;
	}

	protected void setAuthority(ActiveAuthority authority) {
		this.authority = authority;
	}

	public void addConsumer(Consumer consumer) {
		this.consumers.add(consumer);
	}

	public List<Consumer> getConsumers() {
		return consumers;
	}

	public ConsumerPushHandle getConsumerPushFailedHandle() {
		return consumerPushFailedHandle;
	}

}
