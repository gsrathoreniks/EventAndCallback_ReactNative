/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React, {Component} from 'react';
import {NativeModules, Button, View} from 'react-native';
import {DeviceEventEmitter} from 'react-native';
const {CalendarModule} = NativeModules;

export default class App extends Component {
  async componentDidMount() {

    console.log("componentDidMount")
    DeviceEventEmitter.addListener('eventHangup', (event) => {
      console.log('Received Event : '+JSON.stringify(event));
      if (JSON.stringify(event).includes("hangup"))
        CalendarModule.isCallDisconnected('true');
    });
  }

  render() {
    return(
    <Button
      title="Click to invoke your native module!"
      color="#841584"
    />
    )
  }
}
