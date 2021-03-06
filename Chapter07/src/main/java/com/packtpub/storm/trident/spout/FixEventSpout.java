package com.packtpub.storm.trident.spout;

import java.util.Map;

import storm.trident.spout.ITridentSpout;
import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.tuple.Fields;

@SuppressWarnings("rawtypes")
public class FixEventSpout implements ITridentSpout<Long> {

	private static final long serialVersionUID = 1L;

	SpoutOutputCollector collector;
	BatchCoordinator<Long> coordinator = new DefaultCoordinator();
	Emitter<Long> emitter = new FixEventEmitter();

	@Override
	public BatchCoordinator<Long> getCoordinator(String txStateId, Map conf, TopologyContext context) {
		return coordinator;
	}

	@Override
	public Emitter<Long> getEmitter(String txStateId, Map conf, TopologyContext context) {
		return emitter;
	}

	@Override
	public Map getComponentConfiguration() {
		return null;
	}

	@Override
	public Fields getOutputFields() {
		return new Fields("message");
	}

}