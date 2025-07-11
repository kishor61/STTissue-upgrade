UPDATE [stock_operator]
   SET [position] = :position
      ,[operator_name] = :operatorName
      ,[date] = :edate
      ,[crew] = :crew
      ,[shift] = :shift
      ,[hd_storage_chest_col1] = :hdStorageChestCol1
      ,[hd_storage_chest_col2_inbound] = :hdStorageChestCol2Inbound
      ,[hd_storage_chest_col2_outbound] = :hdStorageChestCol2Outbound
      ,[hd_storage_chest_col3] = :hdStorageChestCol3
      ,[hd_storage_chest_col4_inbound] = :hdStorageChestCol4Inbound
      ,[hd_storage_chest_col4_outbound] = :hdStorageChestCol4Outbound
      ,[hd_storage_chest_col5] = :hdStorageChestCol5
      ,[hd_storage_chest_col6_inbound] = :hdStorageChestCol6Inbound
      ,[hd_storage_chest_col6_outbound] =:hdStorageChestCol6Outbound
      ,[hd_storage_chest_col7] = :hdStorageChestCol7
      ,[hd_storage_chest_col8_inbound] = :hdStorageChestCol8Inbound
      ,[hd_storage_chest_col8_outbound] =:hdStorageChestCol8Outbound
      ,[hd_storage_chest_col1_Desc] =:hdStorageChestCol1Desc
      ,[hd_storage_chest_col2_Desc] =:hdStorageChestCol2Desc
      ,[hd_storage_chest_col3_Desc] =:hdStorageChestCol3Desc
      ,[hd_storage_chest_col4_Desc] =:hdStorageChestCol4Desc
      ,[hd_storage_chest_col5_Desc] =:hdStorageChestCol5Desc
      ,[hd_storage_chest_col6_Desc] =:hdStorageChestCol6Desc
      ,[hd_storage_chest_col7_Desc] =:hdStorageChestCol7Desc
      ,[hd_storage_chest_col8_Desc] =:hdStorageChestCol8Desc
      ,[blend_chest_col1] = :blendChestCol1
      ,[blend_chest_col2_inbound] = :blendChestCol2Inbound
      ,[blend_chest_col2_outbound] =:blendChestCol2Outbound
      ,[blend_chest_col3] = :blendChestCol3
      ,[blend_chest_col4_inbound] = :blendChestCol4Inbound
      ,[blend_chest_col4_outbound] =:blendChestCol4Outbound
      ,[blend_chest_col1_Desc] = :blendChestCol1Desc
      ,[blend_chest_col2_Desc] = :blendChestCol2Desc
      ,[blend_chest_col3_Desc] = :blendChestCol3Desc
      ,[blend_chest_col4_Desc] = :blendChestCol4Desc
      ,[see_screen_feed_tand_col1] = :seeScreenFeedTandCol1
      ,[see_screen_feed_tand_col2_inbound] = :seeScreenFeedTandCol2Inbound
      ,[see_screen_feed_tand_col2_outbound] =:seeScreenFeedTandcol2Outbound
      ,[see_screen_feed_tand_col3] = :seeScreenFeedTandCol3
      ,[see_screen_feed_tand_col4_inbound] = :seeScreenFeedTandCol4Inbound
      ,[see_screen_feed_tand_col4_outbound] =:seeScreenFeedTandcol4Outbound
      ,[see_screen_feed_tand_col1_Desc] = :seeScreenFeedTandCol1Desc
      ,[see_screen_feed_tand_col2_Desc] = :seeScreenFeedTandCol2Desc
      ,[see_screen_feed_tand_col3_Desc] = :seeScreenFeedTandCol3Desc
      ,[see_screen_feed_tand_col4_Desc] = :seeScreenFeedTandCol4Desc
      ,[machine_chest_col1] = :machineChestCol1
      ,[machine_chest_col2_inbound] = :machineChestCol2Inbound
      ,[machine_chest_col2_outbound] =:machineChestCol2Outbound
      ,[machine_chest_col3] = :machineChestCol3
      ,[machine_chest_col4_inbound] = :machineChestCol4Inbound
      ,[machine_chest_col4_outbound] =:machineChestCol4Outbound
      ,[machine_chest_col5] =:machineChestCol5
      ,[machine_chest_col6_inbound] = :machineChestCol6Inbound
      ,[machine_chest_col6_outbound] =:machineChestCol6Outbound
      ,[machine_chest_col1_Desc] = :machineChestCol1Desc
      ,[machine_chest_col2_Desc] = :machineChestCol2Desc
      ,[machine_chest_col3_Desc] = :machineChestCol3Desc
      ,[machine_chest_col4_Desc] = :machineChestCol4Desc
      ,[machine_chest_col5_Desc] = :machineChestCol5Desc
      ,[machine_chest_col6_Desc] = :machineChestCol6Desc
      ,[cleanners_col1] = :cleannersCol1
      ,[cleanners_col2] = :cleannersCol2
      ,[cleanners_col3_inbound] = :cleannersCol3Inbound
      ,[cleanners_col3_outbound] =:cleannersCol3Outbound
      ,[cleanners_col1_Desc] = :cleannersCol1Desc
      ,[cleanners_col2_Desc] = :cleannersCol2Desc
      ,[cleanners_col3_Desc] = :cleannersCol3Desc
      ,[de_link_stock_col1] = :deLinkStockCol1
      ,[de_link_stock_col2_inbound] = :deLinkStockCol2Inbound
      ,[de_link_stock_col2_outbound] =:deLinkStockCol2Outbound
      ,[de_link_stock_col1_Desc] = :deLinkStockCol1Desc
      ,[de_link_stock_col2_Desc] = :deLinkStockCol2Desc
      ,[white_water_col1] = :whiteWaterCol1
      ,[white_water_col2_inbound] = :whiteWaterCol2Inbound
      ,[white_water_col2_outbound] =:whiteWaterCol2Outbound
      ,[white_water_col3] = :whiteWaterCol3
      ,[white_water_col4_inbound] = :whiteWaterCol4Inbound
      ,[white_water_col4_outbound] =:whiteWaterCol4Outbound
      ,[white_water_col5] = :whiteWaterCol5
      ,[white_water_col6_inbound] = :whiteWaterCol6Inbound
      ,[white_water_col6_outbound] =:whiteWaterCol6Outbound
      ,[white_water_col7] = :whiteWaterCol7
      ,[white_water_col8_inbound] = :whiteWaterCol8Inbound
      ,[white_water_col8_outbound] =:whiteWaterCol8Outbound
      ,[white_water_col1_Desc] = :whiteWaterCol1Desc
      ,[white_water_col2_Desc] = :whiteWaterCol2Desc
      ,[white_water_col3_Desc] = :whiteWaterCol3Desc
      ,[white_water_col4_Desc] = :whiteWaterCol4Desc
      ,[white_water_col5_Desc] = :whiteWaterCol5Desc
      ,[white_water_col6_Desc] = :whiteWaterCol6Desc
      ,[white_water_col7_Desc] = :whiteWaterCol7Desc
      ,[white_water_col8_Desc] = :whiteWaterCol8Desc
      ,[couch_pit_col1] = :couchPitCol1
      ,[couch_pit_col2] = :couchPitCol2
      ,[couch_pit_col3_inbound] = :couchPitCol3Inbound
      ,[couch_pit_col3_outbound] =:couchPitCol3Outbound
      ,[couch_pit_col4] = :couchPitCol4
      ,[couch_pit_col5_inbound] = :couchPitCol5Inbound
      ,[couch_pit_col5_outbound] =:couchPitCol5Outbound
      ,[couch_pit_col6] = :couchPitCol6
      ,[couch_pit_col7_inbound] = :couchPitCol7Inbound
      ,[couch_pit_col7_outbound] =:couchPitCol7Outbound
      ,[couch_pit_col8_inbound] = :couchPitCol8Inbound
      ,[couch_pit_col8_outbound] =:couchPitCol8Outbound
      ,[couch_pit_col9] = :couchPitCol9
      ,[couch_pit_col10_inbound] = :couchPitCol10Inbound
      ,[couch_pit_col10_outbound] =:couchPitCol10Outbound
      ,[couch_pit_col11_inbound] = :couchPitCol11Inbound
      ,[couch_pit_col11_outbound] =:couchPitCol11Outbound
      ,[couch_pit_col1_Desc] = :couchPitCol1Desc
      ,[couch_pit_col2_Desc] = :couchPitCol2Desc
      ,[couch_pit_col3_Desc] = :couchPitCol3Desc
      ,[couch_pit_col4_Desc] = :couchPitCol4Desc
      ,[couch_pit_col5_Desc] = :couchPitCol5Desc
      ,[couch_pit_col6_Desc] = :couchPitCol6Desc
      ,[couch_pit_col7_Desc] = :couchPitCol7Desc
      ,[couch_pit_col8_Desc] = :couchPitCol8Desc
      ,[couch_pit_col9_Desc] = :couchPitCol9Desc
      ,[couch_pit_col10_Desc] =:couchPitCol10Desc
      ,[couch_pit_col11_Desc] =:couchPitCol11Desc
      ,[yankee_pulper_col1] = :yankeePulperCol1
      
      ,[yankee_pulper_col1_drain] = :yankeePulperCol1Drain
      
      ,[yankee_pulper_col2] = :yankeePulperCol2
      ,[yankee_pulper_col3_inbound] = :yankeePulperCol3Inbound
      ,[yankee_pulper_col3_outbound] =:yankeePulperCol3Outbound
      ,[yankee_pulper_col4] = :yankeePulperCol4
      ,[yankee_pulper_col5_inbound] = :yankeePulperCol5Inbound
      ,[yankee_pulper_col5_outbound] =:yankeePulperCol5Outbound
      ,[yankee_pulper_col6] = :yankeePulperCol6
      ,[yankee_pulper_col7_inbound] = :yankeePulperCol7Inbound
      ,[yankee_pulper_col7_outbound] =:yankeePulperCol7Outbound
      ,[yankee_pulper_col8] = :yankeePulperCol8
      ,[yankee_pulper_col9_inbound] = :yankeePulperCol9Inbound
      ,[yankee_pulper_col9_outbound] =:yankeePulperCol9Outbound
      ,[yankee_pulper_col1_Desc] = :yankeePulperCol1Desc
      
      ,[yankee_pulper_col1_Drain_Desc] = :yankeePulperCol1DrainDesc
      
      ,[yankee_pulper_col2_Desc] = :yankeePulperCol2Desc
      ,[yankee_pulper_col3_Desc] = :yankeePulperCol3Desc
      ,[yankee_pulper_col4_Desc] = :yankeePulperCol4Desc
      ,[yankee_pulper_col5_Desc] = :yankeePulperCol5Desc
      ,[yankee_pulper_col6_Desc] = :yankeePulperCol6Desc
      ,[yankee_pulper_col7_Desc] = :yankeePulperCol7Desc
      ,[yankee_pulper_col8_Desc] = :yankeePulperCol8Desc
      ,[yankee_pulper_col9_Desc] = :yankeePulperCol9Desc
      ,[broke_deflaker_col1] = :brokeDeflakerCol1
      ,[broke_deflaker_col2_inbound] = :brokeDeflakerCol2Inbound
      ,[broke_deflaker_col2_outbound] = :brokeDeflakerCol2Outbound
      ,[broke_deflaker_col3] = :brokeDeflakerCol3
      ,[broke_deflaker_col1_Desc] = :brokeDeflakerCol1Desc
      ,[broke_deflaker_col2_Desc] = :brokeDeflakerCol2Desc
      ,[broke_deflaker_col3_Desc] = :brokeDeflakerCol3Desc
      ,[refining_system_col1] = :refiningSystemCol1
      ,[refining_system_col2] = :refiningSystemCol2
      ,[refining_system_col3_inbound] = :refiningSystemCol3Inbound
      ,[refining_system_col3_outbound] =:refiningSystemCol3Outbound
      ,[refining_system_col4] = :refiningSystemCol4
      ,[refining_system_col5] = :refiningSystemCol5
      ,[refining_system_col6] = :refiningSystemCol6
      ,[refining_system_col7] = :refiningSystemCol7
      ,[refining_system_col8_inbound] = :refiningSystemCol8Inbound
      ,[refining_system_col8_outbound] =:refiningSystemCol8Outbound
      ,[refining_system_col9] = :refiningSystemCol9
      ,[refining_system_col10] =:refiningSystemCol10
      ,[refining_system_col1_Desc] =:refiningSystemCol1Desc
      ,[refining_system_col2_Desc] =:refiningSystemCol2Desc
      ,[refining_system_col3_Desc] =:refiningSystemCol3Desc
      ,[refining_system_col4_Desc] =:refiningSystemCol4Desc
      ,[refining_system_col5_Desc] =:refiningSystemCol5Desc
      ,[refining_system_col6_Desc] =:refiningSystemCol6Desc
      ,[refining_system_col7_Desc] =:refiningSystemCol7Desc
      ,[refining_system_col8_Desc] =:refiningSystemCol8Desc
      ,[refining_system_col9_Desc] =:refiningSystemCol9Desc
      ,[refining_system_col10_Desc] = :refiningSystemCol10Desc
      ,[white_water_pump_col1] = :whiteWaterPumpCol1
      ,[white_water_pump_col2_inbound] = :whiteWaterPumpCol2Inbound
      ,[white_water_pump_col2_outbound] =:whiteWaterPumpCol2Outbound
      ,[white_water_pump_col3] = :whiteWaterPumpCol3
      ,[white_water_pump_col4_inbound] = :whiteWaterPumpCol4Inbound
      ,[white_water_pump_col4_outbound] =:whiteWaterPumpCol4Outbound
      ,[white_water_pump_col5] = :whiteWaterPumpCol5
      ,[white_water_pump_col6_inbound] = :whiteWaterPumpCol6Inbound
      ,[white_water_pump_col6_outbound] =:whiteWaterPumpCol6Outbound
      ,[white_water_pump_col1_Desc] = :whiteWaterPumpCol1Desc
      ,[white_water_pump_col2_Desc] = :whiteWaterPumpCol2Desc
      ,[white_water_pump_col3_Desc] = :whiteWaterPumpCol3Desc
      ,[white_water_pump_col4_Desc] = :whiteWaterPumpCol4Desc
      ,[white_water_pump_col5_Desc] = :whiteWaterPumpCol5Desc
      ,[white_water_pump_col6_Desc] = :whiteWaterPumpCol6Desc
      ,[silo_col1] = :silloCol1
      ,[silo_col2] = :silloCol2
      ,[silo_col3] = :silloCol3
      ,[sillo_col1_Desc] = :silloCol1Desc
      ,[sillo_col2_Desc] = :silloCol2Desc
      ,[sillo_col3_Desc] = :silloCol3Desc
      ,[yankee_pumpler_col1] = :yankeePumplerCol1
      
      ,[yankee_pumpler_col1_Drain] = :yankeePumplerCol1Drain
      
      ,[yankee_pumpler_col2] = :yankeePumplerCol2
      ,[yankee_pumpler_col3_inbound] = :yankeePumplerCol3Inbound
      ,[yankee_pumpler_col3_outbound] =:yankeePumplerCol3Outbound
      ,[yankee_pumpler_col4] = :yankeePumplerCol4
      ,[yankee_pumpler_col5_inbound] = :yankeePumplerCol5Inbound
      ,[yankee_pumpler_col5_outbound] =:yankeePumplerCol5Outbound
      ,[yankee_pumpler_col6] = :yankeePumplerCol6
      ,[yankee_pumpler_col7_inbound] = :yankeePumplerCol7Inbound
      ,[yankee_pumpler_col7_outbound] =:yankeePumplerCol7Outbound
      ,[yankee_pumpler_col8] = :yankeePumplerCol8
      ,[yankee_pumpler_col9_inbound] = :yankeePumplerCol9Inbound
      ,[yankee_pumpler_col9_outbound] =:yankeePumplerCol9Outbound
      ,[yankee_pumpler_col1_Desc] = :yankeePumplerCol1Desc
      
      ,[yankee_pumpler_col1_Drain_Desc] = :yankeePumplerCol1DrainDesc
      
      ,[yankee_pumpler_col2_Desc] = :yankeePumplerCol2Desc
      ,[yankee_pumpler_col3_Desc] = :yankeePumplerCol3Desc
      ,[yankee_pumpler_col4_Desc] = :yankeePumplerCol4Desc
      ,[yankee_pumpler_col5_Desc] = :yankeePumplerCol5Desc
      ,[yankee_pumpler_col6_Desc] = :yankeePumplerCol6Desc
      ,[yankee_pumpler_col7_Desc] = :yankeePumplerCol7Desc
      ,[yankee_pumpler_col8_Desc] = :yankeePumplerCol8Desc
      ,[yankee_pumpler_col9_Desc] = :yankeePumplerCol9Desc
      ,[Broke_system_col1] = :brokeSystemCol1
      ,[Broke_system_col2] = :brokeSystemCol2
      ,[Broke_system_col3] = :brokeSystemCol3
      ,[Broke_system_col4] = :brokeSystemCol4
      ,[Broke_system_col5] = :brokeSystemCol5
      ,[Broke_system_col6] = :brokeSystemCol6
      ,[Broke_system_col7] = :brokeSystemCol7
      ,[Broke_system_col8] = :brokeSystemCol8
      ,[Broke_system_col9] = :brokeSystemCol9
      ,[Broke_system_col10] =:brokeSystemCol10
      ,[Broke_system_col11] =:brokeSystemCol11
      ,[Broke_system_col1_Desc] = :brokeSystemCol1Desc
      ,[Broke_system_col2_Desc] = :brokeSystemCol2Desc
      ,[Broke_system_col3_Desc] = :brokeSystemCol3Desc
      ,[Broke_system_col4_Desc] = :brokeSystemCol4Desc
      ,[Broke_system_col5_Desc] = :brokeSystemCol5Desc
      ,[Broke_system_col6_Desc] = :brokeSystemCol6Desc
      ,[Broke_system_col7_Desc] = :brokeSystemCol7Desc
      ,[Broke_system_col8_Desc] = :brokeSystemCol8Desc
      ,[Broke_system_col9_Desc] = :brokeSystemCol9Desc
      ,[Broke_system_col10_Desc] =:brokeSystemCol10Desc
      ,[Broke_system_col11_Desc] =:brokeSystemCol11Desc
      ,[save_All_col1] = :saveAllCol1
      ,[save_All_col2] = :saveAllCol2
      ,[save_All_col3] = :saveAllCol3
      ,[save_All_col4_inbound] = :saveAllCol4Inbound
      ,[save_All_col4_outbound] =:saveAllCol4Outbound
      ,[save_All_col5] = :saveAllCol5
      ,[save_All_col6] = :saveAllCol6
      ,[save_All_col1_Desc] = :saveAllCol1Desc
      ,[save_All_col2_Desc] = :saveAllCol2Desc
      ,[save_All_col3_Desc] = :saveAllCol3Desc
      ,[save_All_col4_Desc] = :saveAllCol4Desc
      ,[save_All_col5_Desc] = :saveAllCol5Desc
      ,[save_All_col6_Desc] = :saveAllCol6Desc
      ,[hydrapulper_col1] = :hydrapulperCol1
      ,[hydrapulper_col2_inbound] = :hydrapulperCol2Inbound
      ,[hydrapulper_col2_outbound] = :hydrapulperCol2outbound
      ,[hydrapulper_col3] = :hydrapulperCol3
      ,[hydrapulper_col4_inbound] = :hydrapulperCol4Inbound
      ,[hydrapulper_col4_outbound] =:hydrapulperCol4outbound
      ,[hydrapulper_col5] = :hydrapulperCol5
      ,[hydrapulper_col6] = :hydrapulperCol6
      ,[hydrapulper_col7] = :hydrapulperCol7
      ,[hydrapulper_col8_inbound] = :hydrapulperCol8Inbound
      ,[hydrapulper_col8_outbound] =:hydrapulperCol8outbound
      ,[hydrapulper_col9] = :hydrapulperCol9
      ,[hydrapulper_col10_inbound] = :hydrapulperCol10Inbound
      ,[hydrapulper_col10_outbound] =:hydrapulperCol10outbound
      ,[hydrapulper_col11] = :hydrapulperCol11
      ,[hydrapulper_col12] = :hydrapulperCol12
      ,[hydrapulper_col13] = :hydrapulperCol13
      ,[hydrapulper_col14_inbound] = :hydrapulperCol14Inbound
      ,[hydrapulper_col14_outbound] =:hydrapulperCol14outbound
      ,[hydrapulper_col15] = :hydrapulperCol15
      ,[hydrapulper_col16_inbound] =  :hydrapulperCol16Inbound
      ,[hydrapulper_col16_outbound] = :hydrapulperCol16outbound
      ,[hydrapulper_col1_Desc] = :hydrapulperCol1Desc
      ,[hydrapulper_col2_Desc] = :hydrapulperCol2Desc
      ,[hydrapulper_col3_Desc] = :hydrapulperCol3Desc
      ,[hydrapulper_col4_Desc] = :hydrapulperCol4Desc
      ,[hydrapulper_col5_Desc] = :hydrapulperCol5Desc
      ,[hydrapulper_col6_Desc] = :hydrapulperCol6Desc
      ,[hydrapulper_col7_Desc] = :hydrapulperCol7Desc
      ,[hydrapulper_col8_Desc] = :hydrapulperCol8Desc
      ,[hydrapulper_col9_Desc] = :hydrapulperCol9Desc
      ,[hydrapulper_col10_Desc] =:hydrapulperCol10Desc
      ,[hydrapulper_col11_Desc] =:hydrapulperCol11Desc
      ,[hydrapulper_col12_Desc] =:hydrapulperCol12Desc
      ,[hydrapulper_col13_Desc] =:hydrapulperCol13Desc
      ,[hydrapulper_col14_Desc] =:hydrapulperCol14Desc
      ,[hydrapulper_col15_Desc] =:hydrapulperCol15Desc
      ,[hydrapulper_col16_Desc] =:hydrapulperCol16Desc
      ,[desccol1]=:desccol1
      ,[desccol1Desc]=:desccol1Desc
      ,[effluentsamplerworkingcondition]=:effluentsamplerworkingcondition
      ,[effluentsamplerworkingconditionDesc]=:effluentsamplerworkingconditionDesc
 WHERE 
 id=:id
  